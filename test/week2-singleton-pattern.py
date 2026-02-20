class Singleton:
  _instance = None

  def __new__(cls):
    if cls._instance is None:
      cls._instance = super(Singleton, cls).__new__(cls)
    return cls._instance

# Usage
instance1 = Singleton()
instance2 = Singleton()

print(instance1 is instance2) # Output: True
