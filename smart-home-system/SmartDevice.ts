abstract class SmartDevice {
    constructor(public id: number, public type: string) {}
  
    abstract getStatus(): string;
    abstract turnOn(): void;
    abstract turnOff(): void;
  }

  export default SmartDevice;