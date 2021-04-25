import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

class buildH2OMolecule {
    private Semaphore semHydrozen; //= new Semaphore(2);
    private Semaphore semOxygen; // = new Semaphore(1);

    private CyclicBarrier cyclicBarrier;// = new CyclicBarrier(3);
    private int HydrozenCount = 0;
    private int OxyzenCount = 0;
    private int count = 0;
    ArrayList<String> molecules;

    buildH2OMolecule() {
    }

    public void setSyncronizationObjects(ArrayList<String>molecules) {
        this.molecules = molecules;
    }

    public void HydrozenThread() throws InterruptedException, BrokenBarrierException {

        synchronized (this) {
            while( HydrozenCount == 2) {
                this.wait();
            }
            count++;
            HydrozenCount++;
            molecules.add("H");
            if (count == 3) {
                buildMolecule();
            }
        }
    }

    public void OxygenThread() throws InterruptedException, BrokenBarrierException {
        synchronized (this) {
            while(OxyzenCount == 1) {
                this.wait();
            }
            count++;
            OxyzenCount++;
            molecules.add("O");
            if (count == 3) {
                buildMolecule();
            }
        }
    }

    private void buildMolecule() throws BrokenBarrierException, InterruptedException {
        molecules.forEach(System.out::print);
        molecules.clear();
        System.out.println();
        count = 0;
        HydrozenCount = 0;
        OxyzenCount = 0;
        this.notifyAll();
    }
}

enum HydroOxy {
    HYDROGEN,
    OXYGEN
}

class Bond extends Thread {
    buildH2OMolecule obj;
    HydroOxy hydroOxy;
    Bond(buildH2OMolecule obj, HydroOxy hydroOxy) {
        this.obj = obj;
        this.hydroOxy = hydroOxy;
    }

    public void run() {
        if(hydroOxy.equals(HydroOxy.HYDROGEN)) {
            try {
                obj.HydrozenThread();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
        else if(hydroOxy.equals(HydroOxy.OXYGEN)) {
            try {
                obj.OxygenThread();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}

public class build_a_Molecule {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> molecules = new ArrayList<>();
        buildH2OMolecule obj = new buildH2OMolecule();

        obj.setSyncronizationObjects(molecules);

        Bond[] t1 = new Bond[10];
        Bond[] t2 = new Bond[5];

        for(int i = 0; i < 10; i++) {
            t1[i] = new Bond(obj, HydroOxy.HYDROGEN);
        }

        for(int i = 0; i < 5; i++) {
            t2[i] = new Bond(obj, HydroOxy.OXYGEN);
        }

        for(int i = 0; i < 10; i++) {
            t1[i].start();
        }

        for(int i = 0; i < 5; i++) {
            t2[i].start();
        }
        for(int i = 0; i < 10; i++) {
            t1[i].join();
        }
        for(int i = 0; i < 5; i++) {
            t2[i].join();
        }

        System.out.println(" main exited ");
    }
}
