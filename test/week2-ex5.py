class Shape:
  def area(self):
    pass

class Circle(Shape):
  def __init__(self, radius):
    self.radius = radius

  def area(self):
    return 3.14 * self.radius ** 2

circle = Circle(5)
circle_area = circle.area()
print(f"Circle Area: {circle_area}")

