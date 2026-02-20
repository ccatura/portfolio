class Person:
    def __init__(self):
        print("Person is ready")
    def who(self):
        print("Person")
    def work(self):
        print("Works faster")
class Jack(Person):
    def __init__(self):
        super().__init__()
    def who(self):
        print("Jack")
    def run(self):
        print("Runs faster")
p = Jack()
p.who()
p.work()
p.run()