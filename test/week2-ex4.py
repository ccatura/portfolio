from abc import ABC, abstractmethod

class ShapeInterface(ABC):
  @abstractmethod
  def area(self):
    pass

  @abstractmethod
  def perimeter(self):
    pass

class Rectangle(ShapeInterface):
  def __init__(self, length, width):
    self.length = length
    self.width = width

  def area(self):
    return self.length * self.width

  def perimeter(self):
    return 2 * (self.length + self.width)

class Circle(ShapeInterface):
  def __init__(self, radius):
    self.radius = radius

  def area(self):
    return 3.14 * self.radius * self.radius

  def perimeter(self):
    return 2 * 3.14 * self.radius

rectangle = Rectangle(4, 5)
circle = Circle(3)

print("Rectangle Area:", rectangle.area())
print("Rectangle Perimeter:", rectangle.perimeter())

print("Circle Area:", circle.area())
print("Circle Perimeter:", circle.perimeter())

