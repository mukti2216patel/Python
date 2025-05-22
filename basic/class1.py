from random import rrandint
class Train:
    def __init__(self , tnum):
        self.tnum = tnum
    def book(self,tnum , fr , t):
        print(f"ticket booked : from {fr} to {t}")
    def getstatus(self,tnum):
        print("sucess")
    def getfare(self  , fr , t):
        print(f"ticket faree no: {randint(1,61)} from {fr} to {t}")

t = train(12399)
t.book("rampur" , "delhi")
t.getstatus("rampur", "delhi")
t.getfare("rampur" , "delhi")






    
