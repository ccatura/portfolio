theletters = ["aa", 
              "bb",
              "cc",
              "dd"]

theletter = next((theletter for theletter in theletters if theletter == "bb"), None)

print(theletter)