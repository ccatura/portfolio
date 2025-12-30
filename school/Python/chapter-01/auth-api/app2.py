from flask import Flask, request, jsonify

app = Flask(__name__)

# Pretend database of users and their API tokens
users = {
  "user1": "token123",
  "user2": "token456"
}

# Middleware function for authentication
def authenticate(func):
  def wrapper(*args, **kwargs):
    token = request.headers.get("Authorization")
    if token and token.split(" ")[1] in users.values():
      return func(*args, **kwargs)
    else:
      return jsonify({"message": "Authentication failed"}), 401
  return wrapper

@app.route('/protected', methods=['GET'])
@authenticate
def protected_resource():
  return jsonify({"message": "This is a protected resource"})





  # Add role-based authorization
  def authorize(roles):
    def decorator(func):
      def wrapper(*args, **kwargs):
        user_token = request.headers.get("Authorization").split(" ")[1]
        user = next((k for k, v in users.items() if v == user_token), None)
        if user in roles:
          return func(*args, **kwargs)
        else:
          return jsonify({"message": "Authorization failed"}), 403
      return wrapper
    return decorator
  
  # Define user roles
  roles = {
    "user1": ["read"],
    "user2": ["read", "write"]
  }
  
  @app.route('/protected/read', methods=['GET'])
  @authenticate
  @authorize(["read"])
  def read_resource():
    return jsonify({"message": "Read access granted"})
  
  @app.route('/protected/write', methods=['POST'])
  @authenticate
  @authorize(["write"])
  def write_resource():
    return jsonify({"message": "Write access granted"})
  



if __name__ == '__main__':
  app.run()
