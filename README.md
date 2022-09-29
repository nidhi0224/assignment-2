# assignment-2

Screen 1 - Vehicle List 

1. Display an input field and a button 

2. When the button is pressed retrieve a list of vehicles from https://random-data-api.com/api/vehicle/random_vehicle where the number of items retrieved is determined by the input value from the user 

• API documentation can be found here: https://random-data-api.com/legacy_documentation 
 

3. Display the retrieved list sorted by vin below the input field and button 

• For each list item display the vehicle's make_and_model and vin returned from the API 
• Errors or failures from the API call should be handled silently 
 

Screen 2 - Vehicle Details 

4. Allow items on the Vehicle List screen to be clickable and when pressed navigate to a Vehicle Details screen 

5. On the Vehicle Details screen display the following returned from the API: 

• vin 
• make_and_model 
• color 
• car_type 


6. Implement validation for the input field on the Vehicle List screen 

• value must be an integer in the range 1 to 100 
• when the value is in range, proceed with the API call 
• when the value is not in range, do not make an API call and notify the user to make a correction 
 

7. Display a button on the Vehicle Details screen and when pressed: 

• Display a bottom sheet 
• On the bottom sheet display an estimated carbon emissions based on the vehicles kilometrage returned from the API, assuming: o for the first 5000km travelled, 1 unit of carbon is emitted per kilometre 
o after the first 5000km travelled, 1.5 units is emitted per kilometre 
 
 

8. On the Vehicle List screen implement pull down to refresh to retrieve a new list of vehicles using the previous list size 

9. On the Vehicle List screen display a loader while data is being retrieved from the API 