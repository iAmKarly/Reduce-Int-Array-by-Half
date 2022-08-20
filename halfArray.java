import java.util.*;

class halfArrayRemoved{
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> numbers1 = new HashMap<Integer,Integer>();
        int current = arr.length;
        int half = (int)(Math.ceil(arr.length/2));
        int returned = 0;

        for(int i = 0; i < arr.length ;i++)
        {
            int temp = arr[i];
            if(numbers1.get(arr[i]) == null)
            {
                numbers1.put(temp, 1);
            }
            else
            {
                numbers1.replace(temp,numbers1.get(temp)+1);
            }
        }

        while((current > half )&&(numbers1.size()>0))
        {
            int maxValueInMap=(Collections.max(numbers1.values()));
            if (maxValueInMap == 1)
            {
                returned = returned + current - half;
                return returned;
            }
            else{
                for(Map.Entry<Integer, Integer> entry : numbers1.entrySet())
                {
                    Integer value = entry.getValue();
                    Integer key = entry.getKey();
                    if (value==maxValueInMap)
                    {
                        returned++;
                        current-=value;
                        numbers1.remove(key);
                        break;
                    }
                }
            }
        }
        return returned;
    }
}