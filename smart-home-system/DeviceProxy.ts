import SmartDevice from "./SmartDevice";
class DeviceProxy {
    private device: SmartDevice;
  
    constructor(device: SmartDevice) {
      this.device = device;
    }
  
    operate(command: string) {
      if (this.isAuthorized()) {
        if (command === 'turnOn') {
          this.device.turnOn();
        } else if (command === 'turnOff') {
          this.device.turnOff();
        } else {
          console.log('Invalid command');
        }
      } else {
        console.log('Unauthorized access');
      }
    }
  
    private isAuthorized() {
      // Simulate authorization logic
      return true;
    }
  }

  export default DeviceProxy;

  