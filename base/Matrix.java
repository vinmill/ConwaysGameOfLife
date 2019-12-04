char[][] class Matrix {
    public float setMatrix(char[][] arr) {
		float per = 0.10f;//(float)Math.random();
		for(int i = 0; i < arr.length;i++){
			setArray(arr[i], per);
		}
		return per;
	}

	public void setArray(char[] array, float per) {
		for(int i = 0; i < array.length; i++) {
			if (Math.random() < per) {
				array[i] = '1';
			}
			else {
				array[i] = '0';
			}
		}
	}
	
	public void getMatrix(char[][] arr) {
		for(int i = 0; i < arr.length; i++){
			getArray(arr[i]);
		}
		System.out.println();
	}

	public void getArray(char[] array) {
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i]);
		}
		System.out.println();
	}
}