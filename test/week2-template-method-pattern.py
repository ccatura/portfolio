class AbstractClass:
  def template_method(self):
    result = []
    result.append(self.step_one())
    result.append(self.step_two())
    return '\n'.join(result)

  def step_one(self):
    return "Abstract step one"

  def step_two(self):
    return "Abstract step two"

class ConcreteClass(AbstractClass):
  def step_one(self):
    return "Concrete step one"

  def step_two(self):
    return "Concrete step two"

# Usage
abstract_instance = AbstractClass()
concrete_instance = ConcreteClass()

print(abstract_instance.template_method())
# Output:
# Abstract step one
# Abstract step two

print(concrete_instance.template_method())
# Output:
# Concrete step one
# Concrete step two