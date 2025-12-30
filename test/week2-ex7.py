class Calculator:
  def add(self, *args):
    total = sum(args)
    return total

calculator = Calculator()

result1 = calculator.add(2, 4)
result2 = calculator.add(1, 3, 5, 7, 9)

print(f"Result 1: {result1}")
print(f"Result 2: {result2}")

