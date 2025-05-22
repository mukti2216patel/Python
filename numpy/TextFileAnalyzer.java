import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileAnalyzer extends Frame implements ActionListener {
    private TextField fileNameField, selectedLineField;
    private TextArea textArea;
    private Label wordCountLabel, spaceCountLabel, lineCountLabel;
    private Label selectedWordCountLabel, selectedSpaceCountLabel, selectedCharCountLabel;
    private Button loadButton;

    public TextFileAnalyzer() {
        setTitle("Text File Analyzer");
        setSize(600, 600);
        setLayout(new BorderLayout());
        setBackground(new Color(255, 255, 255));

        // Top panel for file input
        Panel topPanel = new Panel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        topPanel.setBackground(new Color(240, 240, 240));
        
        fileNameField = new TextField(30);
        loadButton = new Button("Load File");
        loadButton.setBackground(new Color(70, 130, 180));
        loadButton.setForeground(Color.WHITE);
        
        topPanel.add(new Label("File Name:"));
        topPanel.add(fileNameField);
        topPanel.add(loadButton);

        // Center panel for text area
        textArea = new TextArea(15, 50);
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        textArea.setBackground(new Color(255, 255, 255));
        textArea.setForeground(new Color(0, 0, 0));
        
        // Add mouse listener to handle line clicks
        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int lineIndex = textArea.getText().substring(0, textArea.getCaretPosition()).split("\n").length - 1;
                String selectedLine = getLine(textArea.getText(), lineIndex);
                selectedLineField.setText(selectedLine);
                updateSelectedLineCounts(selectedLine);
            }
        });

        // Bottom panel for counts
        Panel bottomPanel = new Panel();
        bottomPanel.setLayout(new GridLayout(1, 3));
        bottomPanel.setBackground(new Color(240, 240, 240));
        
        wordCountLabel = new Label("Words: 0");
        spaceCountLabel = new Label("Spaces: 0");
        lineCountLabel = new Label("Lines: 0");
        
        bottomPanel.add(wordCountLabel);
        bottomPanel.add(spaceCountLabel);
        bottomPanel.add(lineCountLabel);

        // Panel for selected line and its counts
        Panel selectedLinePanel = new Panel();
        selectedLineField = new TextField(50);
        selectedLineField.setEditable(false);
        
        selectedWordCountLabel = new Label("Selected Line Words: 0");
        selectedSpaceCountLabel = new Label("Selected Line Spaces: 0");
        selectedCharCountLabel = new Label("Selected Line Characters: 0");
        
        selectedLinePanel.add(new Label("Selected Line:"));
        selectedLinePanel.add(selectedLineField);
        selectedLinePanel.add(selectedWordCountLabel);
        selectedLinePanel.add(selectedSpaceCountLabel);
        selectedLinePanel.add(selectedCharCountLabel);

        // Add components to the main frame
        add(topPanel, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        add(selectedLinePanel, BorderLayout.SOUTH);
        
        loadButton.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // Center the frame
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private String getLine(String text, int lineIndex) {
        String[] lines = text.split("\n");
        return (lineIndex < lines.length) ? lines[lineIndex] : "";
    }

    private void updateSelectedLineCounts(String line) {
        int words = line.split("\\s+").length;
        int spaces = line.length() - line.replace(" ", "").length();
        int characters = line.length();

        selectedWordCountLabel.setText("Selected Line Words: " + words);
        selectedSpaceCountLabel.setText("Selected Line Spaces: " + spaces);
        selectedCharCountLabel.setText("Selected Line Characters: " + characters);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String fileName = fileNameField.getText();
        loadFile(fileName);
    }

    private void loadFile(String fileName) {
        textArea.setText("Loading...");
        new Thread(() -> {
            try {
                StringBuilder content = new StringBuilder();
                int wordCount = 0, spaceCount = 0, lineCount = 0;

                try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        content.append(line).append("\n");
                        lineCount++;
                        wordCount += line.split("\\s+").length;
                        spaceCount += line.length() - line.replace(" ", "").length();
                    }
                }

                textArea.setText(content.toString());
                wordCountLabel.setText("Words: " + wordCount);
                spaceCountLabel.setText("Spaces: " + spaceCount);
                lineCountLabel.setText("Lines: " + lineCount);
            } catch (IOException ex) {
                textArea.setText("Error reading file.");
                wordCountLabel.setText("Words: 0");
                spaceCountLabel.setText("Spaces: 0");
                lineCountLabel.setText("Lines: 0");
            }
        }).start();
    }

    public static void main(String[] args) {
        new TextFileAnalyzer();
    }
}
