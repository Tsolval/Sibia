function logSubmit(event) {
    document.getElementById("solo-console").textContent = `Form Submitted!  Timestamp: ${event.timeStamp}`;
    event.preventDefault();
}

function getChaosLevel() {
    // set chaos level
    let cl = '5';
    document.getElementsByName("chaos-level-selections").forEach(element => {
        if (element.checked) { return cl = element.value; }
    })
    return cl;
}

function getUrl(url, callback) {
    let request = new XMLHttpRequest();
    request.open("GET", url);
    request.onreadystatechange = callback;
    request.send();
}

function reportOracle() {
    let head = document.getElementById('solo-console-title');
    let target = document.getElementById('solo-console');
    if(this.readyState === 4 && this.status === 200) {
        let data = JSON.parse(this.responseText);
        head.innerHTML = `${data.dieResult} + ${data.modifier} = ${data.totalResult}`
        target.innerHTML = `${data.description}`;
    }
}

function reportChaos() {
    let head = document.getElementById('solo-console-title');
    let target = document.getElementById('solo-console');
    if(this.readyState === 4 && this.status === 200) {
        let data = JSON.parse(this.responseText);
        head.innerHTML = `${data.dieResult}: ${data.factor}`;
        target.innerHTML = `${data.description}`;
    }
}

function reportEvent() {
    let head = document.getElementById('solo-console-title');
    let target = document.getElementById('solo-console');
    if(this.readyState === 4 && this.status === 200) {
        let data = JSON.parse(this.responseText);
        head.innerHTML = `${data.dieResult}: ${data.type}`;
        target.innerHTML = `${data.description}`;
    }
}

function callOracle(event) {
    event.preventDefault();
    let cl = getChaosLevel();
    let odds = document.getElementById('odds-select').value;
    let url = `api/solo/oracle?cl=${cl}&odds=${odds}`;
    getUrl(url, reportOracle);
}

function positiveEvent(event) {
    event.preventDefault()
    let url = `api/solo/event/positive`;
    getUrl(url, reportEvent);
}

function negativeEvent(event) {
    event.preventDefault()
    let url = `api/solo/event/negative`;
    getUrl(url, reportEvent);
}

function rollChaos(event) {
    event.preventDefault();
    let cl = getChaosLevel();
    let url = `api/solo/chaos?cl=${cl}`;
    getUrl(url, reportChaos);
}

document.getElementById("chaos").addEventListener("click", rollChaos);
document.getElementById("oracle").addEventListener("click", callOracle);
document.getElementById("negative-event").addEventListener("click", positiveEvent);
document.getElementById("positive-event").addEventListener("click", negativeEvent);
