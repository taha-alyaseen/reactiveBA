import http from 'k6/http';
import { check } from "k6";
export let options = {
    setupTimeout: '4m',
    stages: [
        // Ramp-up from 1 to 5 VUs in 5s
        { duration: "25s",  target: 500 },
        // Stay at rest on 5 VUs for 10s
        { duration: "1m", target: 500},
        // Ramp-down from 5 to 0 VUs for 5s
        { duration: "25s",target: 0 }
    ]
};
export default function () {
    const response = http.get(`http://host.docker.internal:${__ENV.MY_PORT}/thirdParty/3000`, {headers: {Accepts: "text/event-stream"}});
    check(response, { "status is 200": (r) => r.status === 200 });
};