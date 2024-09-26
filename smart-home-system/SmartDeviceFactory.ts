// Base class for all devices
import SmartDevice from "./SmartDevice";
  
  // Light class
  class Light extends SmartDevice {
    private status: string = 'off';
  
    turnOn() {
      this.status = 'on';
      console.log(`Light ${this.id} turned on.`);
    }
  
    turnOff() {
      this.status = 'off';
      console.log(`Light ${this.id} turned off.`);
    }
  
    getStatus() {
      return `Light ${this.id} is ${this.status}.`;
    }
  }
  
  // Thermostat class
  class Thermostat extends SmartDevice {
    private temperature: number;
  
    constructor(id: number, temp: number = 70) {
      super(id, 'thermostat');
      this.temperature = temp;
    }
  
    setTemperature(temp: number) {
      this.temperature = temp;
      console.log(`Thermostat ${this.id} is set to ${this.temperature} degrees.`);
    }
  
    getStatus() {
      return `Thermostat ${this.id} is set to ${this.temperature} degrees.`;
    }
  
    turnOn() {
      console.log(`Thermostat ${this.id} is activated.`);
    }
  
    turnOff() {
      console.log(`Thermostat ${this.id} is deactivated.`);
    }
  }
  
  // DoorLock class
  class DoorLock extends SmartDevice {
    private status: string = 'locked';
  
    turnOn() {
      this.status = 'unlocked';
      console.log(`Door ${this.id} is unlocked.`);
    }
  
    turnOff() {
      this.status = 'locked';
      console.log(`Door ${this.id} is locked.`);
    }
  
    getStatus() {
      return `Door ${this.id} is ${this.status}.`;
    }
  }
  
  // Factory Method
  class SmartDeviceFactory {
    static createDevice(id: number, type: string): SmartDevice {
      switch (type) {
        case 'light':
          return new Light(id,type);
        case 'thermostat':
          return new Thermostat(id);
        case 'door':
          return new DoorLock(id,type);
        default:
          throw new Error('Unknown device type');
      }
    }
  }

  export default SmartDeviceFactory;
