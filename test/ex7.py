class WebBrowser:
    def __init__(self, page):
        self.history = [page]
        self.current_page = page
        self.is_incognito = False

    def navigate(self, new_page):
        self.current_page = new_page
        if not self.is_incognito:
            self.history.append(new_page)
    
    def clear_history(self):
            self.history[:-1] = []





vivaldi = WebBrowser("gocampaign.org")
vivaldi.navigate("reddit.com")
vivaldi.navigate("hello.com")
vivaldi.navigate("reddit.com")
vivaldi.clear_history()
print(vivaldi.clear_history)








