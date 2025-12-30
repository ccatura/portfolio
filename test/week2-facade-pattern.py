class SubsystemA:
  def operation_a(self):
    return "Subsystem A operation"

class SubsystemB:
  def operation_b(self):
    return "Subsystem B operation"

class Facade:
  def __init__(self):
    self._subsystem_a = SubsystemA()
    self._subsystem_b = SubsystemB()

  def operation(self):
    result = []
    result.append(self._subsystem_a.operation_a())
    result.append(self._subsystem_b.operation_b())
    return '\n'.join(result)

# Usage
facade = Facade()
print(facade.operation())
