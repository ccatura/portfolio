class OldSystem:
  def perform_action(self):
    return "Old System Action"

class NewSystemAdapter:
  def __init__(self, new_system):
    self._new_system = new_system

  def perform_action(self):
    return self._new_system.perform_new_action()

class NewSystem:
  def perform_new_action(self):
    return "New System Action"

# Usage
old_system = OldSystem()
new_system = NewSystem()
adapter = NewSystemAdapter(new_system)

print(old_system.perform_action()) # Output: Old System Action
print(adapter.perform_action()) # Output: New System Action