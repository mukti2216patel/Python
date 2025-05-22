def gen(n):
    st = ""
    for i in range(1,11):
        st += f"{n} x {i} = {n*i}\n"
    with open(f"tables/tables_{n}.txt" , "w") as f:
            f.write(st);
for i in range(1,11):
    gen(i)