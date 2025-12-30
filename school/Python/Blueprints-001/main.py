from flask import Flask, redirect
from read import read

#instance of server
app = Flask(__name__)

#register the blueprint
app.register_blueprint(read)

#default route
@app.route('/')
def default():
    return redirect('/read')

if __name__ == '__main__':
    app.run(debug=True)