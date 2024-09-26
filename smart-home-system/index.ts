import  SmartDeviceFactory  from './SmartDeviceFactory';
import  SmartHomeHub  from './SmartHomeHub';
import  DeviceProxy  from './DeviceProxy';
import Scheduler  from './Scheduler';
import Automation from './Automation';
import SmartDevice from './SmartDevice';

const hub = new SmartHomeHub();
const light1 = SmartDeviceFactory.createDevice(1, 'light');
const thermostat1 = SmartDeviceFactory.createDevice(2, 'thermostat');
const door1 = SmartDeviceFactory.createDevice(3, 'door');

hub.addDevice(light1);
hub.addDevice(thermostat1);
hub.addDevice(door1);

const lightProxy = new DeviceProxy(light1);
lightProxy.operate('turnOn');

const scheduler = new Scheduler();
scheduler.schedule(thermostat1, "06:00", "Turn On");
console.log(scheduler.getSchedule());

// const automation = new Automation();
// automation.addTrigger(() => (thermostat1 as Thermostat).getStatus().includes('75'), () => lightProxy.operate('turnOff'));
// automation.evaluateTriggers();

console.log(light1.getStatus());
console.log(thermostat1.getStatus());
console.log(door1.getStatus());
