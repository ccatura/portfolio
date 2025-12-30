from flask import request, jsonify
from app import app

@app.route('/api', methods=['POST', 'GET'])
def api():
    if request.method == 'POST':
        data = request.get_json()
        return jsonify(data)
    else:
        return jsonify({"message": "Hello World!"})
    

@app.route('/get-users', methods=['GET'])
def get_users():
    if request.method == 'POST':
        data = request.get_json()
        return jsonify(data)
    else:
        return jsonify({"message": "Got users!"})
    