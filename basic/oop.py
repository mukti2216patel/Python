class Rectangle:
    def __init__(self, length, width):
        self.__length = length  
        self.__width = width   

    def area(self):
        return self.__length * self.__width

    def perimeter(self):
        return 2 * (self.__length + self.__width)

    def print1(self):
        print("hi")
        
    def print2(self):
        print("print2")

class emp:
    name = "xyz"
    num = 234
    def __init__(self, name, num):
        name = self.name
        num = self.num
    def fun():
        print("printing employee class")

rect = Rectangle(5, 3)
print(f"area: {rect.area()}")
print(f"perimeter: {rect.perimeter()}")
rect.print1()  
rect.print2() 
ep1 = emp("mukti" , 234)
print(ep1.name,ep1.num)

