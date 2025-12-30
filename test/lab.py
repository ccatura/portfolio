class MobilePhone:
  def __init__(self, memory):
    self.memory = memory

class Call:
  def talk(self):
    print("Say Hello!")

class Phone(MobilePhone, Call):
  pass

myphone = Phone("200kb")
myphone.talk()
print(myphone.memory)

print(hasattr(myphone, 'memory'))