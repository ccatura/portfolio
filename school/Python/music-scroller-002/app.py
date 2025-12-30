from flask import Flask
from main import main_bp #refers to the "main" directory, then the "main_bp" within the init file
from info import info_bp  # <-- new import

app = Flask(__name__)
app.register_blueprint(main_bp) #registers the blueprint. we need this.
app.register_blueprint(info_bp)  # <-- register the new blueprint

if __name__ == '__main__': #runs the app
    app.run(debug=True)
