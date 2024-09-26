// Observer interface
import SmartDevice from "./SmartDevice";
import SmartDeviceFactory from "./SmartDeviceFactory";
interface Observer {
    update(device: SmartDevice): void;
  }
  
  // Smart Home Hub (Subject)
  class SmartHomeHub {
    private devices: SmartDevice[] = [];
    private observers: Observer[] = [];
  
    addDevice(device: SmartDevice) {
      this.devices.push(device);
      console.log(`Device ${device.type} with id ${device.id} added to the hub.`);
    }
  
    removeDevice(id: number) {
      this.devices = this.devices.filter(device => device.id !== id);
      console.log(`Device with id ${id} removed from the hub.`);
    }
  
    getDeviceById(id: number): SmartDevice | undefined {
      return this.devices.find(device => device.id === id);
    }
  
    addObserver(observer: Observer) {
      this.observers.push(observer);
    }
  
    notifyAll(device: SmartDevice) {
      this.observers.forEach(observer => observer.update(device));
    }
  }

  export default SmartHomeHub;
