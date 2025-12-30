class Light:
  def turn_on(self):
    return "Light is on"

  def turn_off(self):
    return "Light is off"

class LightOnCommand:
  def __init__(self, light):
    self._light = light

  def execute(self):
    return self._light.turn_on()

class LightOffCommand:
  def __init__(self, light):
    self._light = light

  def execute(self):
    return self._light.turn_off()

class RemoteControl:
  def __init__(self):
    self._command = None

  def set_command(self, command):
    self._command = command

  def press_button(self):
    return self._command.execute()

# Usage
light = Light()
light_on = LightOnCommand(light)
light_off = LightOffCommand(light)

remote = RemoteControl()
remote.set_command(light_on)
print(remote.press_button()) # Output: Light is on

remote.set_command(light_off)
print(remote.press_button()) # Output: Light is off
