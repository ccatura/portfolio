import time

# Get the current time in seconds since the epoch
# seconds = time.time()
# print("Seconds since epoch:", seconds)

# Pause execution for a specified number of seconds
# time.sleep(2)  # Pause for 2 seconds
# print("This message is printed after 2 seconds.")

# Get current time as a struct_time object
current_time = time.localtime()
# print("Current time:", current_time)

# Format time as a string
formatted_time = time.strftime("%Y/%m/%d %H:%M", current_time)
print("Formatted time:", formatted_time)