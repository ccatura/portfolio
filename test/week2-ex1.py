class Wheel:
  def __init__(self, size):
    self.size = size

  def spin(self):
    return f"Wheel of size {self.size} spinning."

class Engine:
  def __init__(self, horsepower):
    self.horsepower = horsepower

  def start(self):
    return f"Engine with {self.horsepower} horsepower started."

class Car:
  def __init__(self, engine_horsepower, wheel_size):
    self.engine = Engine(engine_horsepower)
    self.wheels = [Wheel(wheel_size) for _ in range(4)]

  def start(self):
    engine_status = self.engine.start()
    wheels_status = [wheel.spin() for wheel in self.wheels]
    return f"Car started. {engine_status} {', '.join(wheels_status)}"





def main():
  # Create a car with a 200 horsepower engine and 17-inch wheels
  my_car = Car(engine_horsepower=200, wheel_size=17)

  # Start the car
  car_status = my_car.start()
  print(car_status)

if __name__ == "__main__":
  main()

