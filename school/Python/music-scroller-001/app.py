from flask import Flask
from pages.routes import pages_bp  # import blueprint

app = Flask(__name__)
app.register_blueprint(pages_bp)   # register blueprint

if __name__ == "__main__":
    app.run(debug=True)