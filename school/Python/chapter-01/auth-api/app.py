from functools import wraps
from flask import Flask, request, jsonify

app = Flask (__name__)

# Pretend database of users and their API tokens
users = {
    "user1": "token123",
    "user2": "token456"
}

# Define user roles
roles = {
    "user1": ["read"],
    "user2": ["read", "write"]
}

# Middleware function for authentication and authorization
def authenticate_and_authorize (roles_required=[]):
    def decorator(func):
        @wraps(func)
        def wrapper(*args, **kwargs):
            token = request.headers.get("Authorization")
            if token and token.split(" ")[1] in users.values():
                user_token = token.split(" ")[1]

                user = next((k for k, v in users.items() if v == user_token), None)
                if user in roles and any (role in roles_required for role in roles [user]):
                    return func(*args, **kwargs)
            return jsonify({"message": "Authentication or Authorization failed"}), 401
        return wrapper
    return decorator


@app.route('/protected', methods=['GET'])
@authenticate_and_authorize()
def protected_resource():
    return jsonify({"message": "This is a protected resource"})

@app.route('/protected/read', methods=['GET'])
@authenticate_and_authorize(["read"])
def read_resource():
    return jsonify({"message": "Read access granted"})

@app.route('/protected/write', methods=['POST'])
@authenticate_and_authorize(["write"])
def write_resource():
    return jsonify({"message": "write access granted"})

if __name__ == '__main__':
    app.run()
