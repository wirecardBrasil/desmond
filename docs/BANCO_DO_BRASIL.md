# Banco do Brasil

Bank code: `001`

## Calculating the agency check digit

Weight: `5, 4, 3, 2`

1. Multiply each number by the correct weight
2. Sum the results
3. Get the mod of the sum by `11`
4. Subtract the mod by `11`
5. If the result is `11`, then the check digit is `0`.
6. If the result is `10`, then the check digit is `X`. Otherwise, the check digit is the result.

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
    <td>9</td>
    <td>8</td>
  </tr>
</table>

2. Sum the results  
`5 + 8 + 9 + 8 = 30`

3. Get the mod of the sum by `11`  
`30 % 11 = 8`

4. Subtract the mod by `11`  
`11 - 8 = 3`

In this case, the digit would be `3`.

## Calculating the account check digit

Weight: `9, 8, 7, 6, 5, 4, 3, 2`

The account check digit follows the same rules as the [agency check digit](#calculating-the-agency-check-digit). If the account number length is under 8 digits, fill with 0's on the left (Example: `1234` becomes `00001234`).
