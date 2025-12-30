class WebBrowser:
    connected = True

    def __init__(self, page):
        self.history = [page]
        self.current_page = page
        self.is_incognito = False


firefox = WebBrowser("google.com")
iceweasel = WebBrowser("facebook.com")
# print(firefox.connected)
# print(iceweasel.connected)

# print(iceweasel.__dict__)
# print(firefox.__dict__)

#the "connected" attribute is for the class. once we make that attribute for the instance, it creates a new attribute for the instance and no longer looks at the class for that info.
firefox.connected = False
print(firefox.__dict__)

