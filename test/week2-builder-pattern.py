class Pizza:
  def __init__(self):
    self.ingredients = []

  def add_ingredient(self, ingredient):
    self.ingredients.append(ingredient)

  def __str__(self):
    return ", ".join(self.ingredients)

class PizzaBuilder:
  def __init__(self):
    self.pizza = Pizza()

  def add_cheese(self):
     self.pizza.add_ingredient("cheese")

  def add_pepperoni(self):
    self.pizza.add_ingredient("pepperoni")

  def build(self):
    return self.pizza

# Usage
builder = PizzaBuilder()
builder.add_cheese()
builder.add_pepperoni()
pizza = builder.build()

print(pizza) # Output: cheese, pepperoni