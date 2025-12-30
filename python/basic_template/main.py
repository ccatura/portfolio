from flask import Flask, render_template
from second import second #importing the "second" blueprint (variable) from the "second" file
app = Flask(__name__)
app.register_blueprint(second, url_prefix="") #registering the blueprint, I guess so the app knows to use it
@app.route("/")
def test():
    return "<h1>Test</h1>"

if __name__ == "__main__":
    app.run(debug=True)