var offset = 0;
var limit = 20000;


function getReportByName(parseResponse)
{
    let data;
	let xhr = new XMLHttpRequest();
	xhr.open("GET", `/api/reports?name=MES_3_17_23&offset=${offset}`, false);
	xhr.setRequestHeader("Accept", "application/json");
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.setRequestHeader("Authorization", "Token f388d5580c44cc0b7d1720c7de585abd677f5d47");
    xhr.onreadystatechange = function () {
        if (xhr.readyState == XMLHttpRequest.DONE) {
            var response = xhr.responseText;
            parseResponse(response);
        }
    }
    xhr.send(null);
}


var jsonDataHolder = [];
var maxRSquared;
var reportNotFull = true;
let start = Date.now();

while (reportNotFull)
{
    getReportByName(function(result)
    {
        if (result === '[]')
        {
            reportNotFull = false;
            return;
        }
        console.log(offset);
        jsonData = JSON.parse(result);
        for (let i = 0; i < jsonData.length; i++)
        {
            jsonDataHolder.push(jsonData[i]);
        }
        offset += limit;
    })
}

let end = Date.now();
console.log(`Execution time: for report query ${end - start} ms`);

start = Date.now();
maxRSquared = Math.max.apply(Math, jsonData.map(function(o) { return o.r_squared; }));
end = Date.now();
console.log(`Max R squared ${maxRSquared}`);
console.log(`Execution time: for report finding max r value  ${end - start} ms`);