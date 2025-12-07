import os

def dial_decipher():
    file_dir = os.path.dirname(os.path.abspath(__file__))
    file_path = os.path.join(file_dir, "problem_inputs", "day_1_input.txt")

    number_of_0_dials = 0
    current_location = 50
    MAX = 100  # dial size (0–99)

    with open(file_path, "r") as file:
        for line in file:
            line = line.strip()

            # Determine direction and amount
            if "L" in line:
                number = int(line.replace("L", ""))

                # Move left by `number`
                steps = number % MAX
                current_location = (current_location - steps) % MAX

                if current_location == 0:
                    number_of_0_dials += 1

                continue

            if "R" in line:
                number = int(line.replace("R", ""))

                # Move right by `number`
                steps = number % MAX
                current_location = (current_location + steps) % MAX

                if current_location == 0:
                    number_of_0_dials += 1

                continue

    print(number_of_0_dials)

dial_decipher()
