# Assignment

Fund Rounding (Adv)
Use SpringBoot and expose a RESTful API endpoint
Code needs to round up or down by factor '.5' to the nearest integer value. There is a fund that
will be used when rounding up or rounding down. When you round up fund amount will come
down, and fund amount will go up when you round down.

e.g
-
-
-
Initial Fund Amount: 5 (User input)
Values need to be rounded up/down: 1.6, 3.2, 5.5, 7.9, 4, 11.6 (User input as show
above). Rounding will be done like this for 1.6: Nearest integer is 2, that means we need
to add .4 to 1.6 and make it 2. Because we are rounding up .4 will be deducted from
initial fund, reducing it to 4.6 (initialFund - .4 ).
Same thing has to be done with each input value.
Code needs to make sure maximum values are rounded, Fund value can not go below 0.
At the end code should return what is rounded up/down, with how much value, and what fund
value is left at the end.


Input JSON
{
"values": [1.6, 3.2, 5.5, 7.9, 4, 11.6],
"initialFund": 5
}


Expected output JSON
{
  "roundedDown": [{
  "value": 1.4,
  "afterRounding": 1,
  "difference": 0.4
  }],
  "roundedUp": [{
  "value": 1.6,
  "afterRounding": 2,
  "difference": 0.4
  }],
  "remainingFund": 1.5
}

EndPoint : http://localhost:8080/funds/roundOff

