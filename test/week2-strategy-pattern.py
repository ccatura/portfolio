class PaymentStrategy:
  def pay(self, amount):
    pass

class CreditCardPayment(PaymentStrategy):
  def pay(self, amount):
    return f"Paid ${amount} using Credit Card"

class PayPalPayment(PaymentStrategy):
  def pay(self, amount):
    return f"Paid ${amount} using PayPal"

class PaymentContext:
  def __init__(self, strategy):
    self._strategy = strategy

  def perform_payment(self, amount):
    return self._strategy.pay(amount)

# Usage
credit_card_payment = CreditCardPayment()
paypal_payment = PayPalPayment()

context = PaymentContext(credit_card_payment)
print(context.perform_payment(1000)) # Output: Paid $100 using Credit Card

context = PaymentContext(paypal_payment)
print(context.perform_payment(50)) # Output: Paid $50 using PayPal
