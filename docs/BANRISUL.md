# Banrisul

Bank code: `041`

## Calculating the account check digit

Weight: `3, 2, 4, 7, 6, 5, 4, 3, 2`

1. Multiply each number by the correct weight
2. Sum the results
3. Get the _remainder_ of the sum divided by `11`
5. If the result is `0`, then the check digit is `0`.
6. If the result is `1`, then the check digit is `6`. Otherwise, subtract the _remainder_ from `11`.

Example:

Account number: `358507671`

1. Multiply each number by the correct weight

<table>
  <tr>
    <td></td>
    <td>3</td>
    <td>5</td>
    <td>8</td>
    <td>5</td>
    <td>0</td>
    <td>7</td>
    <td>6</td>
    <td>7</td>
    <td>1</td>
  </tr>
  <tr>
    <td>x</td>
    <td>3</td>
    <td>2</td>
    <td>4</td>
    <td>7</td>
    <td>6</td>
    <td>5</td>
    <td>4</td>
    <td>3</td>
    <td>2</td>
  </tr>
  <tr>
    <td></td>
    <td>9</td>
    <td>10</td>
    <td>32</td>
    <td>35</td>
    <td>0</td>
    <td>35</td>
    <td>24</td>
    <td>21</td>
    <td>2</td>
  </tr>
</table>

2. Sum the results  
`9 + 10 + 32 + 35 + 0 + 35 + 24 + 21 + 2 = 168`

3. Get the _remainder_ of the sum divided by `11`  
`168 % 11 = 3`

6. Subtract the _remainder_ from `11`  
`11 - 3 = 8`

In this case, the digit would be `8`.