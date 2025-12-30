#Exercise 6: Implementing Method Overloading Using Default Arguments

class Calculator:
  def add(self, a, b=None):
    if b is None:
      return a
    else:
      return a + b

calculator = Calculator()

result1 = calculator.add(5)
result2 = calculator.add(3, 7)

print(f"Result 1: {result1}")
print(f"Result 2: {result2}")
