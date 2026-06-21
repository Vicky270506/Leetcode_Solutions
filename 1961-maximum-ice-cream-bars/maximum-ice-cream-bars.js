/**
 * @param {number[]} costs
 * @param {number} coins
 * @return {number}
 */
var maxIceCream = function(costs, coins) {
    const mval = Math.max(...costs);
    const cnt = Array(mval+1).fill(0);

    for(let i=0; i<costs.length; i++)
    {
        cnt[costs[i]]++;
    }
    for (let i = 1; i < cnt.length; i++) {
        cnt[i] += cnt[i - 1];
    }

    const ans = [];

    for(let i=costs.length-1; i>=0; i--)
    {
        ans[cnt[costs[i]] - 1] = costs[i];
        cnt[costs[i]]--;
    }


    let c = 0;
    while(coins >= 0)
    {
        coins -= ans[c++];
    }

    return c-1;
};