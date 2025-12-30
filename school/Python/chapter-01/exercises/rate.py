import time

class RateLimiter:
    def __init__(self, max_tokens, fill_rate):
        self.max_tokens = max_tokens
        self.fill_rate = fill_rate
        self.tokens = max_tokens
        self.last_refill_time = time.time()

    def refill(self):
        current_time = time.time()
        elapsed_time = current_time - self.last_refill_time
        tokens_to_add = elapsed_time * self.fill_rate
        self.tokens = min(self.max_tokens, self.tokens + tokens_to_add)
        self.last_refill_time = current_time

    def consume(self, tokens):
        if tokens <= self.tokens:
            self.tokens -= tokens
            return True
        else:
            return False

# Initialize the rate limiter with a maximum of 10 tokens and a fill rate of 2 tokens per second
limiter = RateLimiter(max_tokens=10, fill_rate=2)

# Simulate API requests
for i in range(1, 16):
    limiter.refill()
    if limiter.consume(1):
        print(f"Request {i}: Request granted")
    else:
        print(f"Request {i}: Request denied (rate limit exceeded)")
    time.sleep(0.5) # Simulate a delay between requests