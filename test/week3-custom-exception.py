#Exceptions should be named with names ending with the word Error. Let's create the RecipeNotValidError you talked about previously as a custom exception:

class RecipeNotValidError(Exception):
    def __init__(self):
        self.message = "Your recipe is not valid"

try:
    raise RecipeNotValidError
except RecipeNotValidError as e:
    print(e.message)


