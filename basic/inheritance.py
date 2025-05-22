class employee:
    comapny = "itc"
    def show(self):
        print(f"the name is {self.name} and the sal is {self.salary}")

# class programmer:
#     company ="google"
#     def show(self):
#         print(f"the name is {self.name} and the salary  is {self.salary}")
#     def showlan(self):
#         print(f"the name is {self.name} and he is good with {self.lan} language")

class programmer(employee):
    comapny = "microsoft"
    def showlan(self):
        print(f"the name is {self.name} and he is good with {self.lan} language")
     

a = employee()
b = programmer()
print(a.company , b.company)