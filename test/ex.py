class Car:
    def __init__(self):
        self.__speed = 300
        self.__color = "black"
    def change_speed(self, new_speed):
        self.__speed = new_speed
    def get_speed(self):
        return self.__speed


charlie = Car()
# charlie.change_speed(1000)
print(charlie.get_speed())