import matplotlib.pyplot as plt

def plot_flight_paths(flights):
    plt.figure(figsize=(8, 8))
    
    colors = ['blue', 'red', 'yellow', 'green', 'purple', 'orange']
    
    for i, flight in enumerate(flights):
        x, y = zip(*flight)
        plt.plot(x, y, 'o-', label=f'Flight {i+1}', color=colors[i % len(colors)], alpha=0.5)
        
        for j, (x_coord, y_coord) in enumerate(flight):
            plt.text(x_coord, y_coord, f'{j+1}', fontsize=12, ha='right')
    
    plt.grid(True)
    plt.xlabel('X Coordinate')
    plt.ylabel('Y Coordinate')
    plt.title('Flight Paths')
    plt.legend()
    plt.show()

def main():
    flights = []
    num_flights = int(input("Enter the number of flights: "))
    
    for i in range(num_flights):
        print(f"Enter coordinates for Flight {i+1} (format: x1,y1 x2,y2 ...): ")
        flight_input = input()
        flight_coords = [tuple(map(int, coord.split(','))) for coord in flight_input.split()]
        flights.append(flight_coords)
    
    plot_flight_paths(flights)

if __name__ == "__main__":
    main()
