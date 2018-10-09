# Bradesco

Bank code: `237`

## Calculating the agency check digit

Weight: `5, 4, 3, 2`

1. Multiply each number by the correct weight
2. Sum the results
3. Get the mod of the sum by `11`
4. Subtract the mod by `11`
5. If the result is `11`, then the check digit is `0`.
6. If the result is `10`, then the check digit is `P`. Otherwise, the check digit is the result.

Example:

Agency number: `1234`

1. Multiply each number by the correct weight

<table>
  <tr>
    <td></td>
    <td>1</td>
    <td>2</td>
    <td>3</td>
    <td>4</td>
  </tr>
  <tr>
    <td>x</td>
    <td>5</td>
    <td>4</td>
    <td>3</td>
    <td>2</td>
  </tr>
  <tr>
    <td></td>
    <td>5</td>
    <td>8</td>
    <td>6</td>
    <td>8</td>
  </tr>
</table>

2. Sum the results  
`5 + 8 + 6 + 8 = 27`

3. Get the mod of the sum by `11`  
`27 % 11 = 5`

4. Subtract the mod by `11`  
`11 - 5 = 6`

In this case, the digit would be `6`.

## Calculating the account check digit

Weight: `2, 7, 6, 5, 4, 3, 2`

1. Multiply each number by the correct weight
2. Sum the results
3. Get the mod of the sum by `11`
5. If the result is `0`, then the check digit is `0`.
6. If the result is `1`, then the check digit is `P`. Otherwise, the check digit is the subtraction of the mod by `11`.

Example:

Account number: `1234567`

1. Multiply each number by the correct weight

<table>
  <tr>
    <td></td>
    <td>1</td>
    <td>2</td>
    <td>3</td>
    <td>4</td>
    <td>5</td>
    <td>6</td>
    <td>7</td>
  </tr>
  <tr>
    <td>x</td>
    <td>2</td>
    <td>7</td>
    <td>6</td>
    <td>5</td>
    <td>4</td>
    <td>3</td>
    <td>2</td>
  </tr>
  <tr>
    <td></td>
    <td>2</td>
    <td>14</td>
    <td>18</td>
    <td>20</td>
    <td>20</td>
    <td>18</td>
    <td>14</td>
  </tr>
</table>

2. Sum the results  
`2 + 14 + 18 + 20 + 20 + 18 + 14 = 106`

3. Get the mod of the sum by `11`  
`106 % 11 = 7`

5. Subtract the mod by `11`  
`11 - 7 = 4`

In this case, the digit would be `4`.
