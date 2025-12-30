class Coffee:
  def cost(self):
    return 5

class MilkDecorator:
  def __init__(self, coffee):
    self._coffee = coffee

  def cost(self):
    return self._coffee.cost() + 2

# Usage
coffee = Coffee()
coffee_with_milk = MilkDecorator(coffee)

print(coffee.cost()) # Output: 5
print(coffee_with_milk.cost()) # Output: 7

