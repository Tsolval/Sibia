function logSubmit(event) {
    document.getElementById("solo-console").textContent = `Form Submitted!  Timestamp: ${event.timeStamp}`;
    event.preventDefault();
}

function callOracle(event) {
    event.preventDefault();
    let cl = '5';
    let odds = document.getElementById('odds-select').value;
    // set chaos level
    document.getElementsByName("chaos-level-selections").forEach(element => {
        if (element.checked) { return cl = element.value; }
    })

    let head = document.getElementById('solo-console-title');
    let target = document.getElementById('solo-console');
    let request = new XMLHttpRequest();
    let url = `solo/oracle?cl=${cl}&odds=${odds}`;
    request.open("GET", url);
    request.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            let data = JSON.parse(this.responseText);
            head.innerHTML = `${data.dieResult} + ${data.modifier} = ${data.totalResult}`
            target.innerHTML = `${data.description}`;
        }
    }
    request.send();
}

document.getElementById("solo-form").addEventListener("submit", callOracle);